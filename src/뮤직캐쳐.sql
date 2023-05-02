select*from mc_member;
select*from mc_ranking;
alter table mc_member
modify column constraint PK_id primary key id;
 ALTER TABLE mc_member
   MODIFY COLUMN id String PRIMARY KEY

select nick from mc_member