drop table if exists _uid;

create table _uid ( seq BIGINT NOT NULL );

insert into _uid values (0);

drop function if exists nextUid;

delimiter //
create function nextUid() returns BIGINT
begin
    declare current BIGINT;
    select max(seq) from _uid into current; 
    set current = current + 1;
    update _uid set seq = current;
    return current;
end

//
delimiter ;

