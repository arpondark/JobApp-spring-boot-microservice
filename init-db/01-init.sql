-- Create JobApp database if it doesn't exist
CREATE DATABASE IF NOT EXISTS JobApp;

-- Use the JobApp database
USE JobApp;

-- Grant privileges to the jobapp_user
GRANT ALL PRIVILEGES ON JobApp.* TO 'jobapp_user'@'%';
FLUSH PRIVILEGES;

-- Optional: Insert sample data
-- This will be executed after Hibernate creates the tables
