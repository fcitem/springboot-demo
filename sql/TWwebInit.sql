-- 创建表
create table SYS_MENU
(
  menu_id     varchar(32) not null,
  menu_name   varchar(32),
  parent_id   varchar(32),
  menu_url    varchar(255),
  status      INTEGER,
  menu_sort   INTEGER,
  create_time DATE,
  menu_desc   varchar(255),
  menu_opname varchar(32),
  menu_icon   varchar(32)
);
alter table SYS_MENU add constraint SYS_MENU_PK primary key (MENU_ID);

create table SYS_PERMISSION
(
  permission_id      varchar(32) not null,
  permission_name    varchar(32),
  permission_desc    varchar(255),
  permission_display varchar(255),
  permission_type    varchar(32),
  permission_sort    INTEGER,
  link_menuid        varchar(2000)
);
alter table SYS_PERMISSION add constraint SYS_PERMISSION_PK primary key (PERMISSION_ID);


create table SYS_ROLE
(
  role_id   varchar(32) not null,
  role_name varchar(32),
  status    varchar(32),
  role_desc varchar(255),
  role_sort INTEGER
);
alter table SYS_ROLE add constraint SYS_ROLE_PK primary key (ROLE_ID);

create table SYS_ROLE_PERMISSION
(
  id            varchar(32) not null,
  role_id       varchar(32),
  menu_id       varchar(32),
  permission_id varchar(32),
  menu_permiss  varchar(255)
);
alter table SYS_ROLE_PERMISSION add constraint SYS_ROLE_PERMISSION_PK primary key (ID);

create table SYS_USER
(
  user_id     varchar(32) not null,
  user_name   varchar(32),
  login_id    varchar(32) not null,
  user_pwd    varchar(32),
  create_time DATE,
  status      INTEGER,
  email       varchar(32),
  telephone   varchar(32),
  user_desc   varchar(255)
);
alter table SYS_USER add constraint SYS_USER_PK primary key (USER_ID);

create table SYS_USER_ROLE
(
  id      varchar(32) not null,
  user_id varchar(32) not null,
  role_id varchar(32)
);
alter table SYS_USER_ROLE add constraint SYS_USER_ROLE_PK primary key (ID);
-- --插入原始数据
insert into SYS_MENU (menu_id, menu_name, parent_id, menu_url, status, menu_sort, create_time, menu_desc, menu_opname, menu_icon)
values ('f5f467557b7341b691588b39c675bdf4', '用户管理', '1', '/user/userView.jsp', 1, 1, to_date('04-11-2016 15:55:52', 'dd-mm-yyyy hh24:mi:ss'), null, 'user', 'fa fa-user');
insert into SYS_MENU (menu_id, menu_name, parent_id, menu_url, status, menu_sort, create_time, menu_desc, menu_opname, menu_icon)
values ('5739943dfb2c46ddbd4e09259e780a83', '权限管理', '1', '/permission/permissionView.jsp', 1, 3, to_date('04-11-2016 16:00:39', 'dd-mm-yyyy hh24:mi:ss'), null, 'permission', 'fa fa-user-secret');
insert into SYS_MENU (menu_id, menu_name, parent_id, menu_url, status, menu_sort, create_time, menu_desc, menu_opname, menu_icon)
values ('1', '系统管理', '0', '/main.jsp', 1, 1, to_date('04-11-2016', 'dd-mm-yyyy'), '系统管理', 'system', 'fa fa-cogs');
insert into SYS_MENU (menu_id, menu_name, parent_id, menu_url, status, menu_sort, create_time, menu_desc, menu_opname, menu_icon)
values ('2000212313', '菜单管理', '1', '/menuTreeTable/menuView.jsp', 1, 4, to_date('04-11-2016', 'dd-mm-yyyy'), '菜单管理', 'menu', 'fa fa-gear');
insert into SYS_MENU (menu_id, menu_name, parent_id, menu_url, status, menu_sort, create_time, menu_desc, menu_opname, menu_icon)
values ('3', '角色管理', '1', '/role/roleView.jsp', 1, 2, to_date('04-11-2016', 'dd-mm-yyyy'), '角色管理', 'role', 'fa fa-filter');
insert into SYS_PERMISSION (permission_id, permission_name, permission_desc, permission_display, permission_type, permission_sort, link_menuid)
values ('002', 'add', 'add', 'add', '0', 1, null);
insert into SYS_PERMISSION (permission_id, permission_name, permission_desc, permission_display, permission_type, permission_sort, link_menuid)
values ('003', 'delete', 'delete', 'delete', '0', 1, null);
insert into SYS_PERMISSION (permission_id, permission_name, permission_desc, permission_display, permission_type, permission_sort, link_menuid)
values ('004', 'update', 'update', 'update', '0', 1, null);
insert into SYS_PERMISSION (permission_id, permission_name, permission_desc, permission_display, permission_type, permission_sort, link_menuid)
values ('001', 'view', 'view', 'view', '0', 1, null);
insert into SYS_PERMISSION (permission_id, permission_name, permission_desc, permission_display, permission_type, permission_sort, link_menuid)
values ('005', 'authorize', 'authorize', 'authorize', '0', 1, null);
insert into SYS_ROLE (role_id, role_name, status, role_desc, role_sort)
values ('001', 'Manager', '1', '系统管理员', 1);
insert into SYS_ROLE_PERMISSION (id, role_id, menu_id, permission_id, menu_permiss)
values ('54159610af3d402782a52a4eba8e724c', '001', '1', '002', 'system:add');
insert into SYS_ROLE_PERMISSION (id, role_id, menu_id, permission_id, menu_permiss)
values ('993c96a0e9e84ab09df83b1843b4d4b8', '001', '1', '003', 'system:delete');
insert into SYS_ROLE_PERMISSION (id, role_id, menu_id, permission_id, menu_permiss)
values ('cdf8cc6cbc454272852a6d04181b326e', '001', '1', '004', 'system:update');
insert into SYS_ROLE_PERMISSION (id, role_id, menu_id, permission_id, menu_permiss)
values ('dc96ead7dcac4658b73350f75465c2a6', '001', '1', '001', 'system:view');
insert into SYS_ROLE_PERMISSION (id, role_id, menu_id, permission_id, menu_permiss)
values ('15d669600743497188b6c760d480992b', '001', '1', '005', 'system:authorize');
insert into SYS_ROLE_PERMISSION (id, role_id, menu_id, permission_id, menu_permiss)
values ('2cc1571b1b4d49d481ca2e029c15cf41', '001', '3', '002', 'role:add');
insert into SYS_ROLE_PERMISSION (id, role_id, menu_id, permission_id, menu_permiss)
values ('305551acdd6b4ce3a0393901c80b2623', '001', '3', '003', 'role:delete');
insert into SYS_ROLE_PERMISSION (id, role_id, menu_id, permission_id, menu_permiss)
values ('78dbf256dec64f6cb9d9159bf14308da', '001', '3', '004', 'role:update');
insert into SYS_ROLE_PERMISSION (id, role_id, menu_id, permission_id, menu_permiss)
values ('6c3819db5c5b4e95bc452617633f1ccb', '001', '3', '001', 'role:view');
insert into SYS_ROLE_PERMISSION (id, role_id, menu_id, permission_id, menu_permiss)
values ('e508d5a97c524a82856d3f65e8b8cd46', '001', '2000212313', '005', 'menu:authorize');
insert into SYS_ROLE_PERMISSION (id, role_id, menu_id, permission_id, menu_permiss)
values ('8887493e1806465f86be5a62a0cd71ff', '001', 'f5f467557b7341b691588b39c675bdf4', '002', 'user:add');
insert into SYS_ROLE_PERMISSION (id, role_id, menu_id, permission_id, menu_permiss)
values ('410055add7b44e87916cef8358618c8e', '001', 'f5f467557b7341b691588b39c675bdf4', '003', 'user:delete');
insert into SYS_ROLE_PERMISSION (id, role_id, menu_id, permission_id, menu_permiss)
values ('de377122db954cfb858f6dec959a6fa3', '001', 'f5f467557b7341b691588b39c675bdf4', '004', 'user:update');
insert into SYS_ROLE_PERMISSION (id, role_id, menu_id, permission_id, menu_permiss)
values ('72fc7f13049f48e29116ab5b199f7579', '001', 'f5f467557b7341b691588b39c675bdf4', '001', 'user:view');
insert into SYS_ROLE_PERMISSION (id, role_id, menu_id, permission_id, menu_permiss)
values ('0fb18ec939514584bd86bec33520aea1', '001', 'f5f467557b7341b691588b39c675bdf4', '005', 'user:authorize');
insert into SYS_ROLE_PERMISSION (id, role_id, menu_id, permission_id, menu_permiss)
values ('72ae90f21ae346378a1a51f84ab322a2', '001', '5739943dfb2c46ddbd4e09259e780a83', '002', 'permission:add');
insert into SYS_ROLE_PERMISSION (id, role_id, menu_id, permission_id, menu_permiss)
values ('26bd9f58797a4c26aeb3c64085c66aab', '001', '5739943dfb2c46ddbd4e09259e780a83', '003', 'permission:delete');
insert into SYS_ROLE_PERMISSION (id, role_id, menu_id, permission_id, menu_permiss)
values ('222cafd7582a48769789aa87f49b6b45', '001', '5739943dfb2c46ddbd4e09259e780a83', '004', 'permission:update');
insert into SYS_ROLE_PERMISSION (id, role_id, menu_id, permission_id, menu_permiss)
values ('edbf1c83503a4f81b5bd5d573dc6bb28', '001', '5739943dfb2c46ddbd4e09259e780a83', '001', 'permission:view');
insert into SYS_ROLE_PERMISSION (id, role_id, menu_id, permission_id, menu_permiss)
values ('c7dc32ee76334f8f8a5b286c3f64bdc2', '001', '5739943dfb2c46ddbd4e09259e780a83', '005', 'permission:authorize');
insert into SYS_ROLE_PERMISSION (id, role_id, menu_id, permission_id, menu_permiss)
values ('001', '001', '2000212313', '001', 'menu:view');
insert into SYS_ROLE_PERMISSION (id, role_id, menu_id, permission_id, menu_permiss)
values ('002', '001', '2000212313', '002', 'menu:add');
insert into SYS_ROLE_PERMISSION (id, role_id, menu_id, permission_id, menu_permiss)
values ('003', '001', '2000212313', '003', 'menu:delete');
insert into SYS_ROLE_PERMISSION (id, role_id, menu_id, permission_id, menu_permiss)
values ('004', '001', '2000212313', '004', 'menu:update');
insert into SYS_ROLE_PERMISSION (id, role_id, menu_id, permission_id, menu_permiss)
values ('005', '001', '3', '005', 'role:authorize');
insert into SYS_USER (user_id, user_name, login_id, user_pwd, create_time, status, email, telephone, user_desc)
values ('qwewqewqed', 'twadmin', 'twadmin', '1234', to_date('04-11-2016', 'dd-mm-yyyy'), 1, null, null, '系统管理员');
insert into SYS_USER_ROLE (id, user_id, role_id)
values ('001', 'qwewqewqed', '001');
commit;