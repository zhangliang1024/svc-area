  #1. 操作原来的表,查询数据
  select province_name,province_code from position_village GROUP BY position_village.province_name,province_code

  select city_name,city_code from position_village  where position_village.province_name = '内蒙古自治区' GROUP BY position_village.city_name,city_code

  select province_name from position_village GROUP BY position_village.province_name

  select positionvi0_.county_name as col_0_0_, positionvi0_.county_code as col_1_0_ from position_village positionvi0_ where positionvi0_.city_name= '鄂尔多斯市' group by positionvi0_.county_name , positionvi0_.county_code

  #2. 操作新表 ,测试数据是否一致
  select * from dict_administrative_areas where dict_administrative_areas.area_name = '内蒙古自治区'

  select * from dict_administrative_areas where dict_administrative_areas.parent_id = 3

  select * from dict_administrative_areas where dict_administrative_areas.parent_id = 58

  delete from dict_administrative_areas where dict_administrative_areas.area_code = 0  OR dict_administrative_areas.area_code IS null

  SELECT * from dict_administrative_areas where dict_administrative_areas.id = 2369

  SELECT COUNT(*) from dict_administrative_areas where dict_administrative_areas.area_code = 0 AND dict_administrative_areas.area_code IS null

  SELECT COUNT(*) from dict_administrative_areas where dict_administrative_areas.area_code = 0 OR dict_administrative_areas.area_code IS null

  SELECT  * from dict_administrative_areas where dict_administrative_areas.area_code = 0 OR dict_administrative_areas.area_code IS null

  #3. 清空数据库，重新导入数据
  truncate table dict_administrative_areas;

  SELECT COUNT(*) from dict_administrative_areas;

  SELECT * from dict_administrative_areas