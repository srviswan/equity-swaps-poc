CREATE TABLE rule_definition (
    id                VARCHAR(64)    NOT NULL,
    version           INT            NOT NULL,
    category          VARCHAR(20)    NOT NULL,
    target            VARCHAR(30)    NOT NULL,
    effective_from    DATE           NOT NULL,
    effective_to      DATE,
    enabled           BIT            NOT NULL DEFAULT 1,
    evaluation_mode   VARCHAR(20),
    specificity_boost DECIMAL(6,2)   DEFAULT 0,
    body              NVARCHAR(MAX)  NOT NULL,
    status            VARCHAR(20)    NOT NULL,
    created_by        VARCHAR(64),
    created_at        DATETIME2      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT pk_rule_definition PRIMARY KEY (id, version)
);
CREATE INDEX ix_rule_cat_tgt_eff ON rule_definition (category, target, effective_from);

CREATE TABLE action_template (
    id      VARCHAR(64)   NOT NULL,
    version INT           NOT NULL,
    target  VARCHAR(30)   NOT NULL,
    body    NVARCHAR(MAX) NOT NULL,
    status  VARCHAR(20)   NOT NULL,
    CONSTRAINT pk_action_template PRIMARY KEY (id, version)
);

CREATE TABLE criteria_fragment (
    id      VARCHAR(64)   NOT NULL,
    version INT           NOT NULL,
    body    NVARCHAR(MAX) NOT NULL,
    status  VARCHAR(20)   NOT NULL,
    CONSTRAINT pk_criteria_fragment PRIMARY KEY (id, version)
);

CREATE TABLE snapshot_publication (
    snapshot_id    VARCHAR(36)   NOT NULL,
    published_at   DATETIME2     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    rule_count     INT,
    template_count INT,
    fragment_count INT,
    checksum       VARCHAR(64),
    CONSTRAINT pk_snapshot_publication PRIMARY KEY (snapshot_id)
);
