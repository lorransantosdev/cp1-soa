CREATE TABLE convocations (
    id SERIAL PRIMARY KEY,
    player_id INT,
    requested_by VARCHAR(100),
    status VARCHAR(50)
);