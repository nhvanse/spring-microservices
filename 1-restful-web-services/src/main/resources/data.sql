insert into user_details(id, birth_date, name)
values (10001l, current_date(), 'user test');

insert into user_details(id, birth_date, name)
values (10002l, current_date(), 'user van');

insert into user_details(id, birth_date, name)
values (10003l, current_date(), 'user abc');

insert into post(id, description, user_id)
values (20001, 'I want to learn Spring', 10001),
       (20002, 'I want to learn AWS', 10002),
       (20003, 'I want to learn Java', 10003);