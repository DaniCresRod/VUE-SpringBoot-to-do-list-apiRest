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
import DynamicUrl from "../components/services/DynamicUrl";

export default {
  setup() {
    const { data, error, isLoading } = useFetch(DynamicUrl);

    return { data, error, isLoading };
  },
};
</script>
