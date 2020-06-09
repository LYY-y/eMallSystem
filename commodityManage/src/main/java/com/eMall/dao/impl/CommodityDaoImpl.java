package com.eMall.dao.impl;

import com.eMall.dao.CommodityDao;
import com.eMall.entity.Commodity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//继承了 JdbcDaoSupport 类后，也就具有了 JDBC 模板属性
@Component("commodityDaoImpl")
public class CommodityDaoImpl extends JdbcDaoSupport implements CommodityDao {
    @Override
    public void insertCommodity(Commodity commodity) {
        String sql = " insert into commodity (com_id, discount_id, ca_id, fe_id, com_name, com_price, com_state, " +
                "com_place, com_stock, com_weight, inDate, outDate, discounted_price) value (?,?,?,?,?,?,?,?,?,?,?,?,?)" ;
        this.getJdbcTemplate().update(sql,commodity.getCom_id(),commodity.getDiscount_id(),commodity.getCa_id(),commodity.getFe_id(),
                commodity.getCom_name(),commodity.getCom_price(),commodity.getCom_state(),commodity.getCom_place(),commodity.getCom_stock(),
                commodity.getCom_weight(),commodity.getInDate(),commodity.getOutDate(),commodity.getDiscounted_price());
    }

    @Override
    public void deleteCommodityById(String com_id) {
        String sql = "delete from commodity where com_id = ?";
        this.getJdbcTemplate().update(sql, com_id);
    }

    @Override
    public void updateCommodity(Commodity commodity) {
        String sql = " update commodity set  discount_id=?, ca_id=?, fe_id=?, com_name=?, com_price=?, com_state=?, " +
                "com_place=?, com_stock=?, com_weight=?, inDate=?, outDate=?, discounted_price=? where com_id  = ?" ;
        this.getJdbcTemplate().update(sql,commodity.getDiscount_id(),commodity.getCa_id(),commodity.getFe_id(),
                commodity.getCom_name(),commodity.getCom_price(),commodity.getCom_state(),commodity.getCom_place(),commodity.getCom_stock(),
                commodity.getCom_weight(),commodity.getInDate(),commodity.getOutDate(),commodity.getDiscounted_price(), commodity.getCom_id());
    }

    @Override
    public List<Commodity> selectAllCommodities() {
        String sql = "select * from commodity";
        List<Commodity> commodities = this.getJdbcTemplate().query(sql,new CommodityRowMapper());
        return commodities;
    }

    @Override
    public List<Commodity> selectCommoditySortByPriceASC() {
        String sql = "select * from commodity order by discounted_price asc";
        List<Commodity> commodities = this.getJdbcTemplate().query(sql,new CommodityRowMapper());
        return commodities;
    }

    private class CommodityRowMapper implements RowMapper<Commodity>{

        @Override
        public Commodity mapRow(ResultSet rs, int i) throws SQLException {
            Commodity commodity = new Commodity();
            commodity.setCom_id(rs.getString("com_id"));
            commodity.setDiscount_id(rs.getString("discount_id"));
            commodity.setCa_id(rs.getString("ca_id"));
            commodity.setFe_id(rs.getString("fe_id"));
            commodity.setCom_name(rs.getString("com_name"));
            commodity.setCom_price(rs.getBigDecimal("com_price"));
            commodity.setCom_state(rs.getString("com_state"));
            commodity.setCom_place(rs.getString("com_place"));
            commodity.setCom_stock(rs.getString("com_stock"));
            commodity.setCom_weight(rs.getDouble("com_weight"));
            commodity.setInDate(rs.getDate("inDate"));
            commodity.setOutDate(rs.getDate("outDate"));
            commodity.setDiscounted_price(rs.getBigDecimal("discounted_price"));
            return commodity;
        }
    }
}

