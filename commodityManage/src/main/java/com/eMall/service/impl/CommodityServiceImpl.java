package com.eMall.service.impl;

import com.eMall.dao.CommodityDao;
import com.eMall.entity.Commodity;
import com.eMall.entity.CommodityPic;
import com.eMall.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
//
@Service("commodityService")
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityDao dao;

    @Override
    public void addCommodity(Commodity commodity, CommodityPic[] commodityPics, long cid) {
        try {
            dao.insertCommodity(commodity);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        for (int i = 0; i < commodityPics.length; i++){
            try {
                dao.insertCommodityPic(commodityPics[i],cid);
            }catch (Exception e){
                System.out.println(e);
            }

        }
        System.out.println("成功增添商品信息");
    }

    @Override
    public List<Commodity> findAllCommodities() {
        return dao.selectAllBasicCommodities();
    }


    @Override
    public void deleteCommodity(String cid) {
        Long cidLong = Long.valueOf(cid);
        //删除本地文件信息
        List<String> pics = dao.selectCommodityAllPics(cidLong);
        try {
            for (String pic_path : pics){
                File file = new File(pic_path);
                if (file.delete()){
                    System.out.println("已成功删除图片");
                }else {
                    System.out.println("本地图片删除失败");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //数据库中删除商品信息
        dao.deleteCommodityById(Long.valueOf(cid));
        System.out.println("成功删除商品信息");
    }

    @Override
    public void updateCommodityInfo(Commodity commodity) {
        try {
            dao.updateCommodity(commodity);
            System.out.println("成功更新商品信息");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public Commodity findOneCommodity(String cid) {
        return dao.selectOneCommodityInfoById(Long.valueOf(cid));
    }


//
//    @Override
//    public List<Commodity> lookUpAllCommoditiesByPriceOrder() {
//        System.out.println("正在查询商品信息");
//        return dao.selectCommoditySortByPriceASC();
//    }
//
//    @Override
//    public Commodity lookUpOneCommodityById() {
//        return null;
//    }
}
