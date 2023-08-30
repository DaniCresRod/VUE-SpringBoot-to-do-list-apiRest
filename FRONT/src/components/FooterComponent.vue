<script>
export default {
  data: () => ({
    links: [
      { name: 'Home', route: '/' },
      { name: 'Team', route: '/team' },
      { name: 'Productos', route: '/products' },
    ],
  }),
};
</script>

<template>
  <v-footer class="custom-footer">
    <v-row justify="center" no-gutters>
      <router-link
        v-for="link in links"
        :key="link.name"
        :to="link.route"
        variant="text"
        color="white"
        class="mx-2 links"
        rounded="x0.5"
      >
        {{ link.name }}
      </router-link>
      <v-col class="text-center mt-4 footerText" cols="12">
        {{ new Date().getFullYear() }} — <strong>ToDs List</strong>
      </v-col>
    </v-row>
  </v-footer>
</template>

<style scoped>
.custom-footer {
  background: linear-gradient(to right, rgba(54, 157, 178, 1), rgba(195, 232, 236, 1));
  color: white;
  padding: 20px; 
  height: auto !important;
  margin-top: 4rem;
}

.links {
  color: white;
  text-decoration: none;
  transition: 0.3s;
}

.links:hover {
  color: rgba(54, 157, 178, 1);
  letter-spacing: 0.15rem;
  padding: 0 1rem;
  font-weight: bolder;
}

.footerText {
  color: rgba(54, 157, 178, 1);
}
</style>
