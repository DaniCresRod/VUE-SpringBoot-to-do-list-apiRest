import http from '../httpCommon';

export default({

    create(ProductData){
        return http.post(`/product`, ProductData);
    }
})

