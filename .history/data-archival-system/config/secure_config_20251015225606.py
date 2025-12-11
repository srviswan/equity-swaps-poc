#!/usr/bin/env python3
"""
Secure Configuration Management for Data Archival System
Handles encrypted credentials and secure connection management
"""

import os
import base64
import json
import logging
from cryptography.fernet import Fernet
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.kdf.pbkdf2 import PBKDF2HMAC
from typing import Dict, Optional
import getpass

class SecureConfig:
    """Secure configuration management with encrypted credential storage"""
    
    def __init__(self, config_file: str = None, master_key: str = None):
        self.config_file = config_file or os.path.join(os.path.dirname(__file__), 'config', 'secure_config.json')
        self.master_key = master_key or self._get_master_key()
        self.cipher_suite = Fernet(self.master_key)
        self.logger = logging.getLogger('SecureConfig')
        
    def _get_master_key(self) -> bytes:
        """Get or generate master encryption key"""
        key_file = os.path.join(os.path.dirname(__file__), 'config', 'master.key')
        
        if os.path.exists(key_file):
            with open(key_file, 'rb') as f:
                return f.read()
        else:
            # Generate new key
            key = Fernet.generate_key()
            os.makedirs(os.path.dirname(key_file), exist_ok=True)
            with open(key_file, 'wb') as f:
                f.write(key)
            os.chmod(key_file, 0o600)  # Read-only for owner
            return key
    
    def _derive_key_from_password(self, password: str, salt: bytes) -> bytes:
        """Derive encryption key from password using PBKDF2"""
        kdf = PBKDF2HMAC(
            algorithm=hashes.SHA256(),
            length=32,
            salt=salt,
            iterations=100000,
        )
        return base64.urlsafe_b64encode(kdf.derive(password.encode()))
    
    def encrypt_value(self, value: str) -> str:
        """Encrypt a string value"""
        encrypted_bytes = self.cipher_suite.encrypt(value.encode())
        return base64.urlsafe_b64encode(encrypted_bytes).decode()
    
    def decrypt_value(self, encrypted_value: str) -> str:
        """Decrypt a string value"""
        encrypted_bytes = base64.urlsafe_b64decode(encrypted_value.encode())
        decrypted_bytes = self.cipher_suite.decrypt(encrypted_bytes)
        return decrypted_bytes.decode()
    
    def load_config(self) -> Dict:
        """Load configuration from encrypted file"""
        if not os.path.exists(self.config_file):
            return {}
        
        try:
            with open(self.config_file, 'r') as f:
                encrypted_config = json.load(f)
            
            decrypted_config = {}
            for key, encrypted_value in encrypted_config.items():
                if key.startswith('encrypted_'):
                    decrypted_key = key.replace('encrypted_', '')
                    decrypted_config[decrypted_key] = self.decrypt_value(encrypted_value)
                else:
                    decrypted_config[key] = encrypted_value
            
            return decrypted_config
        except Exception as e:
            self.logger.error(f"Failed to load config: {e}")
            return {}
    
    def save_config(self, config: Dict):
        """Save configuration to encrypted file"""
        os.makedirs(os.path.dirname(self.config_file), exist_ok=True)
        
        encrypted_config = {}
        for key, value in config.items():
            if key in ['password', 'connection_string', 'api_key']:
                encrypted_config[f'encrypted_{key}'] = self.encrypt_value(str(value))
            else:
                encrypted_config[key] = value
        
        with open(self.config_file, 'w') as f:
            json.dump(encrypted_config, f, indent=2)
        
        os.chmod(self.config_file, 0o600)  # Read-only for owner
    
    def get_connection_string(self, use_environment: bool = True) -> str:
        """Get secure connection string"""
        if use_environment:
            # Try environment variables first
            server = os.getenv('DB_SERVER', 'localhost,1434')
            database = os.getenv('DB_DATABASE', 'master')
            username = os.getenv('DB_USERNAME', 'sa')
            password = os.getenv('DB_PASSWORD')
            
            if password:
                return f"DRIVER={{ODBC Driver 17 for SQL Server}};SERVER={server};DATABASE={database};UID={username};PWD={password};Encrypt=false;"
        
        # Fall back to encrypted config file
        config = self.load_config()
        if 'connection_string' in config:
            return config['connection_string']
        
        # Prompt for credentials if not found
        return self._prompt_for_credentials()
    
    def _prompt_for_credentials(self) -> str:
        """Prompt user for database credentials"""
        print("Database credentials not found. Please provide:")
        server = input("Server (default: localhost,1434): ").strip() or "localhost,1434"
        database = input("Database (default: master): ").strip() or "master"
        username = input("Username (default: sa): ").strip() or "sa"
        password = getpass.getpass("Password: ")
        
        connection_string = f"DRIVER={{ODBC Driver 17 for SQL Server}};SERVER={server};DATABASE={database};UID={username};PWD={password};Encrypt=false;"
        
        # Ask if user wants to save credentials
        save = input("Save credentials securely? (y/N): ").strip().lower()
        if save == 'y':
            config = {
                'server': server,
                'database': database,
                'username': username,
                'connection_string': connection_string
            }
            self.save_config(config)
            print("Credentials saved securely!")
        
        return connection_string
    
    def setup_environment_variables(self):
        """Setup environment variables for secure authentication"""
        env_file = os.path.join(os.path.dirname(__file__), '.env')
        
        if not os.path.exists(env_file):
            print("Creating .env file for environment variables...")
            
            # Generate secure passwords
            import secrets
            db_password = secrets.token_urlsafe(32)
            encryption_key = secrets.token_urlsafe(32)
            
            env_content = f"""# Database Configuration
DB_SERVER=localhost,1434
DB_DATABASE=master
DB_USERNAME=archival_service
DB_PASSWORD={db_password}

# Encryption Configuration
ENCRYPTION_KEY={encryption_key}

# Application Configuration
LOG_LEVEL=INFO
MAX_WORKERS=10
BATCH_SIZE=1000
"""
            
            with open(env_file, 'w') as f:
                f.write(env_content)
            
            os.chmod(env_file, 0o600)  # Read-only for owner
            print(f"Environment file created: {env_file}")
            print("Please update the database password in your SQL Server!")

class ConnectionManager:
    """Manages secure database connections"""
    
    def __init__(self, config: SecureConfig = None):
        self.config = config or SecureConfig()
        self.logger = logging.getLogger('ConnectionManager')
    
    def get_connection_string(self) -> str:
        """Get secure connection string"""
        return self.config.get_connection_string()
    
    def test_connection(self) -> bool:
        """Test database connection"""
        try:
            import pyodbc
            conn_str = self.get_connection_string()
            conn = pyodbc.connect(conn_str)
            conn.close()
            self.logger.info("Database connection test successful")
            return True
        except Exception as e:
            self.logger.error(f"Database connection test failed: {e}")
            return False
    
    def get_docker_connection_string(self) -> str:
        """Get connection string for Docker-based operations"""
        # For Docker operations, we use subprocess calls instead of direct ODBC
        return "docker_exec_connection"

def main():
    """Setup secure authentication"""
    print("🔐 Setting up secure authentication for Data Archival System")
    print("=" * 60)
    
    # Initialize secure config
    config = SecureConfig()
    
    # Setup environment variables
    config.setup_environment_variables()
    
    # Test connection
    conn_manager = ConnectionManager(config)
    if conn_manager.test_connection():
        print("✅ Secure authentication setup completed successfully!")
    else:
        print("❌ Connection test failed. Please check your credentials.")
    
    print("\n📋 Next Steps:")
    print("1. Update your SQL Server with the generated password")
    print("2. Use environment variables in your applications")
    print("3. Never commit .env files to version control")
    print("4. Rotate passwords regularly")

if __name__ == "__main__":
    main()
