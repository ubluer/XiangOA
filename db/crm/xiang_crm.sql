# 客户表
CREATE TABLE crm_customer
(
  id          VARCHAR(64) PRIMARY KEY NOT NULL
  COMMENT '编号',
  name        VARCHAR(200) COMMENT '名称',
  sys_user_id VARCHAR(64) COMMENT '负责人编号',
  vip         VARCHAR(20) COMMENT '客户级别[无，小型客户,中型客户,大型客户,VIP客户]',
  source      VARCHAR(20) COMMENT '客户来源[无,自己开发,客户介绍,展会,其他]',
  classify    VARCHAR(20) COMMENT '客户分类[无,潜在客户,现有客户]',
  status      VARCHAR(20) COMMENT '状态[初步沟通,见面拜访,确认意向.方案评估,商务洽谈,项目暂缓,签署合同,项目实施,售后阶段,客户流失]',
  phone       VARCHAR(30) COMMENT '电话',
  website     VARCHAR(64) COMMENT '网址',
  fax         VARCHAR(64) COMMENT '传真',
  zip         VARCHAR(30) COMMENT '邮编',
  place       VARCHAR(200) COMMENT '地址',
  longitude   DOUBLE COMMENT '标记位置经度',
  latitude    DOUBLE COMMENT '标记位置纬度',
  pitures     VARCHAR(200) COMMENT '图片',
  files       VARCHAR(200) COMMENT '附件',
  create_by   VARCHAR(64)             NOT NULL
  COMMENT '创建者',
  create_date DATETIME                NOT NULL
  COMMENT '创建时间',
  update_by   VARCHAR(64)             NOT NULL
  COMMENT '更新者',
  update_date DATETIME                NOT NULL
  COMMENT '更新时间',
  remarks     VARCHAR(255) COMMENT '备注信息',
  del_flag    CHAR(1) DEFAULT '0'     NOT NULL
  COMMENT '删除标记'
);
CREATE INDEX crm_customer_del_flag
  ON crm_customer (del_flag);

# 跟进人表
CREATE TABLE crm_customer_follower
(
  id              VARCHAR(64) PRIMARY KEY NOT NULL
  COMMENT '编号',
  crm_customer_id VARCHAR(64) COMMENT '客户id',
  sys_user_id     VARCHAR(64) COMMENT '跟进人编号',
  create_by       VARCHAR(64)             NOT NULL
  COMMENT '创建者',
  create_date     DATETIME                NOT NULL
  COMMENT '创建时间',
  update_by       VARCHAR(64)             NOT NULL
  COMMENT '更新者',
  update_date     DATETIME                NOT NULL
  COMMENT '更新时间',
  remarks         VARCHAR(255) COMMENT '备注信息',
  del_flag        CHAR(1) DEFAULT '0'     NOT NULL
  COMMENT '删除标记'
);
CREATE INDEX crm_customer_follower_del_flag
  ON crm_customer_follower (del_flag);

# 跟进记录表
CREATE TABLE crm_customer_follow
(
  id              VARCHAR(64) PRIMARY KEY NOT NULL
  COMMENT '编号',
  crm_customer_id VARCHAR(64) COMMENT '客户id',
  crm_chance_id   VARCHAR(64) COMMENT '机会id',
  crm_contract_id VARCHAR(64) COMMENT '合同id',
  sys_user_id     VARCHAR(64) COMMENT '发布人编号',
  content         VARCHAR(500) COMMENT '发布内容',
  pitures         VARCHAR(200) COMMENT '图片',
  files           VARCHAR(200) COMMENT '附件',
  create_by       VARCHAR(64)             NOT NULL
  COMMENT '创建者',
  create_date     DATETIME                NOT NULL
  COMMENT '创建时间',
  update_by       VARCHAR(64)             NOT NULL
  COMMENT '更新者',
  update_date     DATETIME                NOT NULL
  COMMENT '更新时间',
  remarks         VARCHAR(255) COMMENT '备注信息',
  del_flag        CHAR(1) DEFAULT '0'     NOT NULL
  COMMENT '删除标记'
);
CREATE INDEX crm_customer_follow_del_flag
  ON crm_customer_follow (del_flag);

# 机会表
CREATE TABLE crm_chance
(
  id              VARCHAR(64) PRIMARY KEY NOT NULL
  COMMENT '编号',
  name            VARCHAR(200) COMMENT '机会名称',
  crm_customer_id VARCHAR(64) COMMENT '客户id',
  amount          DOUBLE COMMENT '预计成交金额',
  execution_time  DATETIME COMMENT '预计成交时间',
  progress        VARCHAR(20) COMMENT '销售进度[尚未联系，初步接触，意向过滤，商务跟进，基本谈妥，签单成功，未能签单]',
  degree          VARCHAR(20) COMMENT '机会级别[普通机会，重点机会]',
  pitures         VARCHAR(200) COMMENT '图片',
  files           VARCHAR(200) COMMENT '附件',
  create_by       VARCHAR(64)             NOT NULL
  COMMENT '创建者',
  create_date     DATETIME                NOT NULL
  COMMENT '创建时间',
  update_by       VARCHAR(64)             NOT NULL
  COMMENT '更新者',
  update_date     DATETIME                NOT NULL
  COMMENT '更新时间',
  remarks         VARCHAR(255) COMMENT '备注信息',
  del_flag        CHAR(1) DEFAULT '0'     NOT NULL
  COMMENT '删除标记'
);
CREATE INDEX crm_chance_del_flag
  ON crm_chance (del_flag);

# 合同表
CREATE TABLE crm_contract
(
  id              VARCHAR(64) PRIMARY KEY NOT NULL
  COMMENT '编号',
  name            VARCHAR(200) COMMENT '标题',
  crm_customer_id VARCHAR(64) COMMENT '客户id',
  crm_chance_id   VARCHAR(64) COMMENT '机会id',
  amount          DOUBLE COMMENT '合同金额',
  discount        DOUBLE COMMENT '折扣后金额',
  contarct_date   DATETIME COMMENT '签约日期',
  payment_method  VARCHAR(20) COMMENT '付款方式[现金，汇款，电汇，支付宝，支票，抵押]',
  sys_user_id     VARCHAR(64) COMMENT '我方签约人',
  parties         VARCHAR(200) COMMENT '客户签约人',
  start_time      DATETIME COMMENT '开始日期',
  end_time        DATETIME COMMENT '结束日期',
  pitures         VARCHAR(200) COMMENT '图片',
  files           VARCHAR(200) COMMENT '附件',
  create_by       VARCHAR(64)             NOT NULL
  COMMENT '创建者',
  create_date     DATETIME                NOT NULL
  COMMENT '创建时间',
  update_by       VARCHAR(64)             NOT NULL
  COMMENT '更新者',
  update_date     DATETIME                NOT NULL
  COMMENT '更新时间',
  remarks         VARCHAR(255) COMMENT '备注信息',
  del_flag        CHAR(1) DEFAULT '0'     NOT NULL
  COMMENT '删除标记'
);
CREATE INDEX crm_contract_del_flag
  ON crm_contract (del_flag);

# 合同回款计划表
CREATE TABLE crm_contract_payback_plan
(
  id              VARCHAR(64) PRIMARY KEY NOT NULL
  COMMENT '编号',
  period          INT COMMENT '期数',
  crm_contract_id VARCHAR(64) COMMENT '合同id',
  crm_chance_id   VARCHAR(64) COMMENT '负责人id',
  amount          DOUBLE COMMENT '应收金额',
  execution_time  DATETIME COMMENT '计划日期',
  pitures         VARCHAR(200) COMMENT '图片',
  files           VARCHAR(200) COMMENT '附件',
  create_by       VARCHAR(64)             NOT NULL
  COMMENT '创建者',
  create_date     DATETIME                NOT NULL
  COMMENT '创建时间',
  update_by       VARCHAR(64)             NOT NULL
  COMMENT '更新者',
  update_date     DATETIME                NOT NULL
  COMMENT '更新时间',
  remarks         VARCHAR(255) COMMENT '备注信息',
  del_flag        CHAR(1) DEFAULT '0'     NOT NULL
  COMMENT '删除标记'
);
CREATE INDEX crm_contract_payback_plan_del_flag
  ON crm_contract_payback_plan (del_flag);

# 合同回款记录表
CREATE TABLE crm_contract_payback
(
  id              VARCHAR(64) PRIMARY KEY NOT NULL
  COMMENT '编号',
  period          INT COMMENT '期数',
  crm_contract_id VARCHAR(64) COMMENT '合同id',
  crm_chance_id   VARCHAR(64) COMMENT '负责人id',
  amount          DOUBLE COMMENT '实收金额',
  execution_time  DATETIME COMMENT '实际日期',
  billing         INT COMMENT '是否开票',
  payment_method  VARCHAR(20) COMMENT '付款方式[现金，汇款，电汇，支付宝，支票，抵押]',
  pitures         VARCHAR(200) COMMENT '图片',
  files           VARCHAR(200) COMMENT '附件',
  create_by       VARCHAR(64)             NOT NULL
  COMMENT '创建者',
  create_date     DATETIME                NOT NULL
  COMMENT '创建时间',
  update_by       VARCHAR(64)             NOT NULL
  COMMENT '更新者',
  update_date     DATETIME                NOT NULL
  COMMENT '更新时间',
  remarks         VARCHAR(255) COMMENT '备注信息',
  del_flag        CHAR(1) DEFAULT '0'     NOT NULL
  COMMENT '删除标记'
);
CREATE INDEX crm_contract_payback_del_flag
  ON crm_contract_payback (del_flag);

# 成交记录表
CREATE TABLE crm_contract_approve
(
  id              VARCHAR(64) PRIMARY KEY NOT NULL
  COMMENT '编号',
  crm_contract_id VARCHAR(64) COMMENT '合同id',
  crm_customer_id VARCHAR(64) COMMENT '客户id',
  submitter_id    VARCHAR(64) COMMENT '创建人id,sys_user',
  submit_date     DATETIME COMMENT '提交日期',
  approver_id     VARCHAR(64) COMMENT '审批人id,sys_user',
  approve_date    DATETIME COMMENT '审批日期',
  status          VARCHAR(20) COMMENT '审批状态[审批中，驳回，通过]',
  reason          VARCHAR(200) COMMENT '驳回理由',
  pitures         VARCHAR(200) COMMENT '图片',
  files           VARCHAR(200) COMMENT '附件',
  create_by       VARCHAR(64)             NOT NULL
  COMMENT '创建者',
  create_date     DATETIME                NOT NULL
  COMMENT '创建时间',
  update_by       VARCHAR(64)             NOT NULL
  COMMENT '更新者',
  update_date     DATETIME                NOT NULL
  COMMENT '更新时间',
  remarks         VARCHAR(255) COMMENT '备注信息',
  del_flag        CHAR(1) DEFAULT '0'     NOT NULL
  COMMENT '删除标记'
);
CREATE INDEX crm_contract_approve_del_flag
  ON crm_contract_approve (del_flag);

# 联系人表
CREATE TABLE crm_contact
(
  id              VARCHAR(64) PRIMARY KEY NOT NULL
  COMMENT '编号',
  name            VARCHAR(100) COMMENT '姓名',
  sys_user_id     VARCHAR(64) COMMENT '负责人编号',
  crm_customer_id VARCHAR(64) COMMENT '客户',
  department             VARCHAR(200) COMMENT '部门',
  position          VARCHAR(200) COMMENT '职位',
  meail        VARCHAR(200) COMMENT '邮箱',
  place           VARCHAR(200) COMMENT '地址',
  pitures         VARCHAR(200) COMMENT '图片',
  files           VARCHAR(200) COMMENT '附件',
  create_by       VARCHAR(64)             NOT NULL
  COMMENT '创建者',
  create_date     DATETIME                NOT NULL
  COMMENT '创建时间',
  update_by       VARCHAR(64)             NOT NULL
  COMMENT '更新者',
  update_date     DATETIME                NOT NULL
  COMMENT '更新时间',
  remarks         VARCHAR(255) COMMENT '备注信息',
  del_flag        CHAR(1) DEFAULT '0'     NOT NULL
  COMMENT '删除标记'
);
CREATE INDEX crm_contact_del_flag
  ON crm_contact (del_flag);
# 联系人电话表
CREATE TABLE crm_contact_phone
(
  id             VARCHAR(64) PRIMARY KEY NOT NULL
  COMMENT '编号',
  crm_contact_id VARCHAR(64) COMMENT '联系人id',
  phone          VARCHAR(64) COMMENT '电话',
  create_by      VARCHAR(64)             NOT NULL
  COMMENT '创建者',
  create_date    DATETIME                NOT NULL
  COMMENT '创建时间',
  update_by      VARCHAR(64)             NOT NULL
  COMMENT '更新者',
  update_date    DATETIME                NOT NULL
  COMMENT '更新时间',
  remarks        VARCHAR(255) COMMENT '备注信息',
  del_flag       CHAR(1) DEFAULT '0'     NOT NULL
  COMMENT '删除标记'
);
CREATE INDEX crm_contact_phone_del_flag
  ON crm_contact_phone (del_flag);

# 修改记录表
CREATE TABLE crm_modified
(
  id              VARCHAR(64) PRIMARY KEY NOT NULL
  COMMENT '编号',
  crm_customer_id VARCHAR(64) COMMENT '客户id',
  sys_user_id     VARCHAR(64) COMMENT '修改人id',
  modified_table  VARCHAR(64) COMMENT '修改表名',
  modified_field  VARCHAR(64) COMMENT '修改字段',
  before_modified          VARCHAR(1000) COMMENT '修改前内容',
  after_modified           VARCHAR(1000) COMMENT '修改后内容',
  modified_class  VARCHAR(64) COMMENT '修改实体',
  create_by       VARCHAR(64)             NOT NULL
  COMMENT '创建者',
  create_date     DATETIME                NOT NULL
  COMMENT '创建时间',
  update_by       VARCHAR(64)             NOT NULL
  COMMENT '更新者',
  update_date     DATETIME                NOT NULL
  COMMENT '更新时间',
  remarks         VARCHAR(255) COMMENT '备注信息',
  del_flag        CHAR(1) DEFAULT '0'     NOT NULL
  COMMENT '删除标记'
);
CREATE INDEX crm_modified_del_flag
  ON crm_modified (del_flag);
# 附件表
CREATE TABLE sys_file
(
  id              VARCHAR(64) PRIMARY KEY NOT NULL
  COMMENT '编号',
  filename VARCHAR(200) COMMENT '附件名称',
  extension     VARCHAR(64) COMMENT '附件后缀',
  filepath  VARCHAR(200) COMMENT '附件地址',
  type  VARCHAR(20) COMMENT '附件类型[图片，文件]',
  create_by       VARCHAR(64)             NOT NULL
  COMMENT '创建者',
  create_date     DATETIME                NOT NULL
  COMMENT '创建时间',
  update_by       VARCHAR(64)             NOT NULL
  COMMENT '更新者',
  update_date     DATETIME                NOT NULL
  COMMENT '更新时间',
  remarks         VARCHAR(255) COMMENT '备注信息',
  del_flag        CHAR(1) DEFAULT '0'     NOT NULL
  COMMENT '删除标记'
);
CREATE INDEX sys_file_del_flag
  ON sys_file (del_flag);


