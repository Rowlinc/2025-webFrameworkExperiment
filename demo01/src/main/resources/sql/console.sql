explain select user_id,detail,create_time,update_time from `2023211454`.address a where a.user_id="1416336075241246721";
explain select a.id,a.detail,a.user_id,u.name from `2023211454`.address a
    left join `2023211454`.user u on a.user_id=u.id where a.id="1416340065286836224";
explain select * from `2023211454`.user u
    join `2023211454`.address a on u.id=a.user_id where u.id='1416336075211886592';
explain select u.name,count(a.id) as count from user u left join address a on u.id = a.user_id group by u.id order by count;