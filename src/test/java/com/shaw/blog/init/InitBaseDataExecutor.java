package com.shaw.blog.init;

import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;

import com.mysql.jdbc.Connection;

public class InitBaseDataExecutor {
	public static void main(String[] args) {
		try {
			Properties props = Resources.getResourceAsProperties("generator.properties");
			String url = props.getProperty("generator.jdbc.url");
			String driver = props.getProperty("generator.jdbc.driver");
			String username = props.getProperty("generator.jdbc.username");
			String password = props.getProperty("generator.jdbc.password");
			Class.forName(driver).newInstance();
			Connection conn = (Connection) DriverManager.getConnection(url, username, password);
			System.out.println("初始化数据中...");
			ScriptRunner runner = new ScriptRunner(conn);
			runner.runScript(new InputStreamReader( InitBaseDataExecutor.class.getClassLoader().getResourceAsStream("liquibase/gensql/gen_db.sql"),"UTF-8"));
			runner.runScript(new InputStreamReader( InitBaseDataExecutor.class.getClassLoader().getResourceAsStream("liquibase/sql/init/boss_admin_init.sql"),"UTF-8"));
			runner.closeConnection();
			conn.close();
			System.out.println("初始化数据成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
