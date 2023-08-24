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
    
</script>

