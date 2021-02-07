create table if not exists dept(
  deptno numeric,
  dname  varchar(14),
  loc    varchar(13),
  constraint pk_dept primary key ( deptno )
);

create table if not exists emp(
  empno    numeric,
  ename    varchar(10),
  job      varchar(9),
  mgr      numeric,
  hiredate date,
  sal      numeric,
  comm     numeric,
  deptno   numeric,
  constraint pk_emp primary key ( empno ),
  constraint fk_deptno foreign key ( deptno ) references dept ( deptno )
);