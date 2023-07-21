CREATE TABLE IF NOT EXISTS key_value (
    key TEXT PRIMARY KEY,
    value TEXT
);

ALTER TABLE "user"
    ADD active BOOL NOT NULL DEFAULT TRUE,
    ADD absence INTEGER DEFAULT 0;
