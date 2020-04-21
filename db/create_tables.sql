CREATE TABLE employees (
    emp_id      SERIAL  PRIMARY KEY,
    surname     TEXT    NOT NULL,
    name        TEXT    NOT NULL,
    patronymic  TEXT,
    education   TEXT
);

CREATE TABLE divisions (
    div_id      SERIAL  PRIMARY KEY,
    div_name    TEXT,
    head_div_id INT     REFERENCES divisions(div_id),
    chief_id    INT     REFERENCES employees(emp_id)
);

CREATE TABLE positions (
    pos_id           SERIAL PRIMARY KEY,
    div_id           INT    REFERENCES divisions(div_id),
    pos_name         TEXT,
    responsibilities TEXT
);

CREATE TABLE emp_pos (
    emp_pos_id  SERIAL,
    emp_id      INT     REFERENCES employees(emp_id),
    pos_id      INT     REFERENCES positions(pos_id),
    start_date  DATE,
    finish_date DATE,
    salary      INT
);
