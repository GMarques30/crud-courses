package br.com.crud_cursos.infra.database;

import java.sql.ResultSet;

public interface DatabaseConnection {
  ResultSet query(String statement);
  ResultSet query(String statement,  Object[] params);
  void command(String statement, Object[] params);
  void close();
}
