package com.game.controller;


import java.util.ArrayList;
import java.util.List;

import com.game.DataTransferObject.PlayerDto;
import org.springframework.stereotype.Component;

@Component
public class Paginator {//  разбивка по страницам

    public List<PlayerDto> getPageData(List<PlayerDto> players, final Integer pageNumberValue, final Integer pageSizeValue) {
        List<PlayerDto> result = new ArrayList<>();

        int pageNumber = (pageNumberValue == null)? 0 : pageNumberValue;
        int pageSize = (pageSizeValue == null)? 3 : pageSizeValue;
        int startIndex = pageNumber * pageSize;

        for (int i = 0; i < pageSize; i++) {
            if ((startIndex + i) >= players.size()) {
                break;
            }
            PlayerDto player = players.get(startIndex + i);
            result.add(player);
        }

        return result;
    }

}
