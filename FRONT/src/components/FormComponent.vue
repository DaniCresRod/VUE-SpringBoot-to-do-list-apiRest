
<script>

  export default {
    data: () => ({
      name: '',
      nameRules: [
        v => !!v || 'Frase es obligatoria',
        v => (v && v.length <= 20) || 'Name must be less than 20 characters',
      ],
      select: null,
      items: [
        'Camiseta',
        'Sudadera',
        'Taza',
        'Botella',
      ],

      size:[
        'S',
        'M',
        'L',
        'XL',
      ],

      colour:[
        'Blanco',
        'Negro',
        'Rojo',
        'Azul',
        'Amarillo',
        'Verde',
        'Rosa',
        'Violeta',
      ],

      checkbox: false,
    }),

    methods: {
      async validate () {
        const { valid } = await this.$refs.form.validate()

        if (valid) alert('Form is valid')
      },
      reset () {
        this.$refs.form.reset()
      },
      resetValidation () {
        this.$refs.form.resetValidation()
      },

    },
  }
</script>


<template>
  <v-sheet width="300" class="mx-auto">

    <v-form ref="form">
      <v-text-field
        v-model="name"
        :counter="20"
        :rules="nameRules"
        label="Frase mierda here please"
        required
      ></v-text-field>

      <v-select
        v-model="select"
        :items="items"
        :rules="[v => !!v || 'Item is required']"
        label="Producto"
        required
      ></v-select>

      <v-select
        v-if="select === 'Camiseta' || select === 'Sudadera'"
        :items="size"
        :rules="[v => !!v || 'Item is required']"
        label="Talla"
      ></v-select>

      <v-select
        :items="colour"
        :rules="[v => !!v || 'Item is required']"
        label="Color"
      ></v-select>

      <v-checkbox
        v-model="checkbox"
        :rules="[v => !!v || 'You must agree to continue!']"
        label="Do you agree?"
        required
      ></v-checkbox>

      <div class="d-flex flex-column">
        <v-btn
          color="success"
          class="mt-4"
          block
          @click="validate"
        >
          Validate
        </v-btn>

        <v-btn
          color="error"
          class="mt-4"
          block
          @click="reset"
        >
          Reset Form
        </v-btn>

        <v-btn
          color="warning"
          class="mt-4"
          block
          @click="resetValidation"
        >
          Reset Validation
        </v-btn>
      </div>
    </v-form>
  </v-sheet>
</template>
