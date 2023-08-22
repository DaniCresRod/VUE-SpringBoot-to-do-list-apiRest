<template>
    <div>
    <div v-if="error">Error: {{ error.message }}</div>
    <div v-else-if="isLoading">Cargando...</div>
    <div v-else>
        <div v-for="products in data" :key="product.id">{{ product.name }}</div>
    </div>
    </div>
</template>
  
<script>
import useFetch from "../components/hooks/useFetch";
import dynamicUrl from "../components/services/dynamicUrl";

export default {
  setup() {
    const { data, error, isLoading } = useFetch(dynamicUrlynamicUrl);

    return { data, error, isLoading };
  },
};
</script>

