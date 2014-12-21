/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.latihan.belajarswingworker.daoimpl;

import com.latihan.belajarswingworker.dao.Daokaryawan;
import com.latihan.belajarswingworker.domain.Karyawan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Artha
 */
public class DaoImplKaryawan implements Daokaryawan{

    private Connection Connection;

    public DaoImplKaryawan(Connection connection) {
        this.Connection=connection;
    }
    
    @Override
    public List<Karyawan> getKaryawans() {
        List<Karyawan> karyawans = new ArrayList<Karyawan>();
        String sql="SELECT id, nama, alamat, tanggal_lahir,telephone from karyawan";
        Karyawan k = null;
        try{
            PreparedStatement statement = Connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                k = new Karyawan();
                k.setId(rs.getLong(1));
                k.setNama(rs.getString(2));
                k.setAlamat(rs.getString(3));
                k.setTanggalLahir(rs.getDate(4));
                k.setTelephone(rs.getString(5));
                karyawans.add(k);
                k=null;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return karyawans;
    }
}
