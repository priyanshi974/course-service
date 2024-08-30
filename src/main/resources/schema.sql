create table if not exists `courses` (
`id` int AUTO_INCREMENT primary key,
`title` varchar(30) not null,
`author` varchar(30) not null,
`duration` varchar(30) not null,
`created_at` DATE default null,
`created_by` varchar(30) default null,
`updated_at` date default null,
`updated_by` varchar(30) default null
);

create table if not exists `enrollment` (
`id` int AUTO_INCREMENT primary key,
`emp_id` int not null,
`course_id` int not null,
`status` varchar(30) not null
);