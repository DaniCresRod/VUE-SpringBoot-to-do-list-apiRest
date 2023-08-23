import http from '../httpCommon';

class ProductData{

    create(ProductData){
        return http.post(`/product`, ProductData);
    }

}

