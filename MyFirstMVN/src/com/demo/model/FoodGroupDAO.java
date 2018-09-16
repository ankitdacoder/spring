package com.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;


@Component("foodGroupDAO")
public class FoodGroupDAO {
	
	//private JdbcTemplate myJdbcTemlate; 
	
	private NamedParameterJdbcTemplate myJdbcTemlate; 
	
	public NamedParameterJdbcTemplate getMyJdbcTemlate() {
		return myJdbcTemlate;
	}

	@Autowired 
	public void setMyJdbcTemlate(DataSource ds) {
		//this.myJdbcTemlate = new JdbcTemplate(ds);
		this.myJdbcTemlate = new NamedParameterJdbcTemplate(ds);
	}

	public List<FoodGroup> getFoodGroups()
	{
		MapSqlParameterSource myMap=new MapSqlParameterSource();
		myMap.addValue("groupName", "Honey");
		
		 
		return myJdbcTemlate.query("SELECT * FROM foodgroups where name=:groupName",myMap, new RowMapper<FoodGroup>() {

			public FoodGroup mapRow(ResultSet rs, int rowNum) throws SQLException {
			
				 FoodGroup fg=new FoodGroup();
				 fg.setId(rs.getInt("id"));
				 fg.setName(rs.getString("name")); 
				 fg.setDescription(rs.getString("description"));
				 
				 return fg;
				
			}
			
		});
	}
	
	public FoodGroup getFoodGroup(int id)
	{
		MapSqlParameterSource myMap=new MapSqlParameterSource();
		myMap.addValue("id", id);
		
		return myJdbcTemlate.queryForObject("select * from foodgroups where id=:id", myMap, new RowMapper<FoodGroup>() {

			public FoodGroup mapRow(ResultSet rs, int rowNum) throws SQLException {
			    
				 FoodGroup fg=new FoodGroup();
				 fg.setId(rs.getInt("id"));
				 fg.setName(rs.getString("name")); 
				 fg.setDescription(rs.getString("description"));
				
				return fg;
			}
		});
	}
	//Insert Record using simple method
	public Boolean addFoodGroup(String name,String description)
	{
		Boolean res = false;

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("name", name);
		param.addValue("description", description);
		int rowAff = myJdbcTemlate.update("insert into foodgroups (name,description) values (:name,:description)",
				param);

		if (rowAff == 1) {
			res = true;
			System.out.println("One Row Inserted " + rowAff);
		} else {
			System.out.println("No row Inserted");

		}

		return res;
	}
	//Insert Record using BeanProperty 
	public Boolean create(FoodGroup fg)
	{  Boolean res=false;
		BeanPropertySqlParameterSource beanInsert=new BeanPropertySqlParameterSource(fg);
		int rowAff = myJdbcTemlate.update("insert into foodgroups (name,description) values (:name,:description)",
				beanInsert);

		if (rowAff == 1) {
			res = true;
			System.out.println("One Row Inserted Bean Property" + rowAff);
		} else {
			System.out.println("No row Inserted");

		}
		
		return res;
	}
	
	public Boolean update(FoodGroup fg)
	{
		Boolean res = false;

		BeanPropertySqlParameterSource beanUpdate = new BeanPropertySqlParameterSource(fg);

		int rowAff = myJdbcTemlate.update("update foodgroups set name=:name,description=:description where id=:id",
				beanUpdate);

		if (rowAff == 1) {
			res = true;
			System.out.println("One Row Updated " + rowAff);
		} else {
			System.out.println("No row Inserted");

		}

		return res;

	}
	
	//delete record 
	
	public Boolean delete(int id)
	{
		Boolean res = false;
		MapSqlParameterSource delParam = new MapSqlParameterSource();
		delParam.addValue("id", id);

		int rowAff = myJdbcTemlate.update("delete from foodgroups where id=:id ", delParam);
		if (rowAff == 1) {
			res = true;
			System.out.println("Row Deleted" + rowAff);
		} else {
			System.out.println("No Row Deleted");

		}
		return res;

	}
	
	

}
