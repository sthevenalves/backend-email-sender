CREATE TABLE msEmail(
     id TEXT PRIMARY KEY UNIQUE NOT NULL,
     ownerRef TEXT NOT NULL,
     emailFrom TEXT NOT NULL,
     emailTo TEXT NOT NULL,
     subject TEXT NOT NULL,
     text TEXT NOT NULL,
     sendDateEmail TIMESTAMP NOT NULL,
     statusEmail TEXT NOT NULL
);