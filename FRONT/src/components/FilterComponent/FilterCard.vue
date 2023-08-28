<script>
export default {
  props: {
    card: Object
  },
  methods: {
    // Aquí puedes agregar tus métodos como cancelfavorite
    cancelfavorite(productId) {
      // Realiza la lógica necesaria utilizando productId y card
      // Por ejemplo, puedes emitir un evento personalizado
      this.$emit("cancel-favorite", productId);
    }
  }
}
</script>

<template>
  <v-card>
    <v-img
      :src="card.src"
      class="align-end"
      gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
      height="200px"
      cover
    >
      <v-card-title class="text-white">{{ card.prodMessage }}</v-card-title>
    </v-img>
    <v-card-actions>
      <v-card-subtitle class="mt-4 text-subtitle-2" v-text="'Producto: ' + (card.prodType)"></v-card-subtitle>
      <v-card-subtitle class="mt-4 text-subtitle-2" v-text="'Talla: ' + (card.prodType === 'Camiseta' || card.prodType === 'Sudadera' ? card.prodSize : 'Única')"></v-card-subtitle>
      <v-spacer></v-spacer>
      <v-btn size="medium" color="surface-variant" variant="text"><i class="fas fa-heart-broken"></i></v-btn>
    </v-card-actions>
  </v-card>
</template>
