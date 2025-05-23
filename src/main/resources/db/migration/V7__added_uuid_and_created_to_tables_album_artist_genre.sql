ALTER TABLE album
    ADD created_on TIMESTAMP(6) WITH TIME ZONE DEFAULT now();

ALTER TABLE album
    ADD uuid UUID DEFAULT gen_random_uuid() NOT NULL UNIQUE;

ALTER TABLE artist
    ADD created_on TIMESTAMP(6) WITH TIME ZONE DEFAULT now();

ALTER TABLE artist
    ADD uuid UUID DEFAULT gen_random_uuid() NOT NULL UNIQUE;

ALTER TABLE genre
    ADD created_on TIMESTAMP(6) WITH TIME ZONE DEFAULT now();

ALTER TABLE genre
    ADD uuid UUID DEFAULT gen_random_uuid() NOT NULL UNIQUE;

