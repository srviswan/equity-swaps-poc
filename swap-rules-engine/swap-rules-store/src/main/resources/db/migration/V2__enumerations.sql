CREATE TABLE enumeration (
    code                     VARCHAR(80)   NOT NULL,
    display_name             VARCHAR(200)  NOT NULL,
    description              VARCHAR(500),
    provider_type            VARCHAR(40)   NOT NULL,
    source_config            NVARCHAR(MAX),
    refresh_policy           VARCHAR(40)   NOT NULL DEFAULT 'MANUAL',
    refresh_interval_seconds INT,
    version                  INT           NOT NULL DEFAULT 1,
    updated_at               DATETIME2     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT pk_enumeration PRIMARY KEY (code)
);

CREATE TABLE enumeration_value (
    id            BIGINT        IDENTITY(1,1) NOT NULL,
    enum_code     VARCHAR(80)   NOT NULL,
    value_code    VARCHAR(120)  NOT NULL,
    display_label VARCHAR(200),
    sort_order    INT           DEFAULT 0,
    active        BIT           NOT NULL DEFAULT 1,
    metadata      NVARCHAR(MAX),
    valid_from    DATE,
    valid_to      DATE,
    CONSTRAINT pk_enumeration_value PRIMARY KEY (id),
    CONSTRAINT uk_enum_value UNIQUE (enum_code, value_code)
);

CREATE INDEX ix_enum_value_code ON enumeration_value (enum_code, active);
