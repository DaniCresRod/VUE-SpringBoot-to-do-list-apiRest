import http from '../httpCommon';

export default ProductData({

    create(ProductData){
        return http.post(`/product`, ProductData);
    }
})

