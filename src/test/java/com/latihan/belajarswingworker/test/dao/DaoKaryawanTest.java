/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.latihan.belajarswingworker.test.dao;

import com.latihan.belajarswingworker.dao.Daokaryawan;
import com.latihan.belajarswingworker.domain.Karyawan;
import com.latihan.belajarswingworker.util.Koneksi;
import java.util.List;
import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;
/**
 *
 * @author Bandenk
 */
public class DaoKaryawanTest {
    private Daokaryawan daokaryawan;
    
    @Before
    public void createDao(){
        daokaryawan = Koneksi.getDaokaryawan();
    }
    @Test
    public void testDao(){
        List<Karyawan>karyawans = daokaryawan.getKaryawans();
        Assert.assertNotEquals(0, karyawans.size());
        System.out.println(karyawans.size());
    }
}
