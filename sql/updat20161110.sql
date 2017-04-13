--社保参数基础信息表里增加年度城市相连值的属性
alter table rs_insurance add year_city varchar(60) DEFAULT '' comment '年度城市';
--修改企业社保缴费比例的sys_module的url /companyshebaoController/companyshebaoList 2016年11月16日
update sys_module set url='/companyshebaoController/companyshebaoList' where code='peo-2-4';