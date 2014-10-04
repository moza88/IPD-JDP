REM Start the HSQLDB as the server before changing the DBUtility
java -cp lib/hsqldb.jar org.hsqldb.Server -database.0 file:mydb -dbname.0 xdb