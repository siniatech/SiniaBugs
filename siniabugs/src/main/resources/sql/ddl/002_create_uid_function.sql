create table _uid ( seq BIGINT NOT NULL );

insert into _uid values (0);

drop function if exists nextUid;

delimiter //
create function nextUid() returns INT
begin
    declare current INT;
    select max(seq) from _uid into current; 
    set current = current + 1;
    update _uid set seq = current;
    return current;
end

//
delimiter ;

0	14:27:02	INSERT INTO BUGS_USER VALUES(1, nextUid(), "Sinia", "Bugs", NOW(), null, 1, 1)	Error Code: 1175. You are using safe update mode and you tried to update a table without a WHERE that uses a KEY column To disable safe mode, toggle the option in Preferences -> SQL Editor -> Query Editor and reconnect.
