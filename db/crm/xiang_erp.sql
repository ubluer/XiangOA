# 工程项目表
CREATE TABLE erp_project
(
  id          VARCHAR(64) PRIMARY KEY NOT NULL
  COMMENT '编号',
  name        VARCHAR(200) NOT NULL COMMENT '名称',
  sys_user_id VARCHAR(64) COMMENT '负责人编号',
  crm_contract_id VARCHAR(64) COMMENT '项目合同',
  vip         VARCHAR(20) COMMENT '级别[无，小型,中型,大型,VIP]',
  source      VARCHAR(20) COMMENT '来源[无,自己开发,客户介绍,展会,其他]',
  status      VARCHAR(20) COMMENT '状态[初步沟通,见面拜访,确认意向.方案评估,商务洽谈,项目暂缓,签署合同,项目实施,售后阶段,客户流失]',
  place       VARCHAR(200) COMMENT '地址',
  longitude   DOUBLE COMMENT '标记位置经度',
  latitude    DOUBLE COMMENT '标记位置纬度',
  pictures     VARCHAR(200) COMMENT '图片',
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
CREATE INDEX erp_project_del_flag
  ON erp_project (del_flag);

# 项目参与人表
CREATE TABLE erp_project_follower
(
  id          VARCHAR(64) PRIMARY KEY NOT NULL
  COMMENT '编号',
  erp_project_id VARCHAR(64) COMMENT '项目id',
  name        VARCHAR(200) NOT NULL COMMENT '名称',
  sys_user_id VARCHAR(64) COMMENT '负责人编号',
  crm_customer_id VARCHAR(64) COMMENT '参与客户',
  classify    VARCHAR(20) COMMENT '参与类型[负责人,供应商及劳务单位]',
  content      VARCHAR(200) COMMENT '参与内容',
  pictures     VARCHAR(200) COMMENT '图片',
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
CREATE INDEX erp_project_follower_del_flag
  ON erp_project_follower (del_flag);

# 工程日报表
CREATE TABLE erp_daily
(
  id              VARCHAR(64) PRIMARY KEY NOT NULL
  COMMENT '编号',
  erp_project_id VARCHAR(64) COMMENT '工程id',
  sys_user_id     VARCHAR(64) COMMENT '记录人编号',
  content         VARCHAR(500) COMMENT '日报',
  weather         VARCHAR(50) COMMENT '天气',
  cost            DOUBLE  COMMENT '花费',
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
CREATE INDEX erp_daily_del_flag
  ON erp_daily (del_flag);

# 工程材料管理
CREATE TABLE erp_repertory
(
  id              VARCHAR(64) PRIMARY KEY NOT NULL
  COMMENT '编号',
  erp_project_id VARCHAR(64) COMMENT '工程id',
  sys_user_id     VARCHAR(64) COMMENT '记录人编号',
  name            VARCHAR(200) COMMENT '名称',
  type            VARCHAR(20) COMMENT '类型[主材,辅材,劳保用品]',
  edition         VARCHAR(64) COMMENT '规格',
  detail          VARCHAR(200) COMMENT '规格描述',
  count       DOUBLE COMMENT '库存数量',
  unit            VARCHAR(20) COMMENT '单位',
  cost            DOUBLE  COMMENT '花费',
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
CREATE INDEX erp_repertory_del_flag
  ON erp_repertory (del_flag);

# 工程材料消费管理
CREATE TABLE erp_repertory_cost
(
  id              VARCHAR(64) PRIMARY KEY NOT NULL
  COMMENT '编号',
  erp_project_id VARCHAR(64) COMMENT '工程id',
  sys_user_id     VARCHAR(64) COMMENT '记录人编号',
  erp_repertory_id VARCHAR(64) COMMENT '材料id',
  count       DOUBLE COMMENT '库存数量变化',
  unit            VARCHAR(20) COMMENT '单位',
  cost            DOUBLE  COMMENT '花费',
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
CREATE INDEX erp_repertory_cost_del_flag
  ON erp_repertory_cost (del_flag);
