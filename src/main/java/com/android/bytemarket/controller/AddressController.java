package com.android.bytemarket.controller;

import com.android.bytemarket.common.ServerResponse;
import com.android.bytemarket.entity.Address;
import com.android.bytemarket.service.AddressService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/list")
    public ServerResponse list(@RequestParam("uid")Integer uid){
        //无校验
        List<Address> list =addressService.list(new QueryWrapper<Address>().eq("user_id",uid));
        return ServerResponse.ofSuccess(list);
    }

    @PostMapping("/")
    public ServerResponse save(@RequestBody Address address){
        boolean b = addressService.saveOrUpdate(address);
        if (b) {
            return ServerResponse.ofSuccess(address);
        }
        else {
            return ServerResponse.ofError();
        }
    }

    @DeleteMapping("/{id}")
    public ServerResponse delete(@PathVariable("id") Integer id){
        //无校验
        boolean b = addressService.removeById(id);
        if (b) {
            return ServerResponse.ofSuccess("删除成功");
        }
        else {
            return ServerResponse.ofError("删除失败");
        }
    }
}
