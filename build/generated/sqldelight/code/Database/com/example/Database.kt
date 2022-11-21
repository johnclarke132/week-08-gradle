package com.example

import com.ddbb.LecturerQueries
import com.ddbb.TestQueries
import com.example.`week-08-gradle`.newInstance
import com.example.`week-08-gradle`.schema
import com.squareup.sqldelight.Transacter
import com.squareup.sqldelight.db.SqlDriver

public interface Database : Transacter {
  public val lecturerQueries: LecturerQueries

  public val testQueries: TestQueries

  public companion object {
    public val Schema: SqlDriver.Schema
      get() = Database::class.schema

    public operator fun invoke(driver: SqlDriver): Database = Database::class.newInstance(driver)
  }
}
