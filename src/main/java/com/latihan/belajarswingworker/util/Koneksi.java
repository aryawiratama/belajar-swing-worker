/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.latihan.belajarswingworker.util;

import com.latihan.belajarswingworker.dao.Daokaryawan;
import com.latihan.belajarswingworker.daoimpl.DaoImplKaryawan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Artha
 */
public class Koneksi {
    private static Connection connection;
    private static Daokaryawan daokaryawan;
    
    private  Koneksi(){
        
    }

    private static Connection getConnection() {
        if (connection==null){
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/belajarswingworker", "root", "root");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static Daokaryawan getDaokaryawan() {
        if (daokaryawan==null){
            daokaryawan = new DaoImplKaryawan(getConnection());
        }
        return daokaryawan;
    }
    
}
