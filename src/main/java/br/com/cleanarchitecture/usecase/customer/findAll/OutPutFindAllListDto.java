package br.com.cleanarchitecture.usecase.customer.findAll;

import java.util.ArrayList;
import java.util.List;

public class OutPutFindAllListDto {
    private List<OutPutFindAllDto> outPutFindAllDtoList;

    public OutPutFindAllListDto(List<OutPutFindAllDto> outPutFindAllDtoList) {
        this.outPutFindAllDtoList = outPutFindAllDtoList;
    }

    public List<OutPutFindAllDto> getOutPutFindAllDtoList() {
        return outPutFindAllDtoList;
    }
}

