<template>
  <div>
    <AppHeader></AppHeader>
    <AppMain></AppMain>
    <app-footer></app-footer>
    <!-- Footer -->

  </div>
</template>

<script>
import AppHeader from '@/components/AppHeader';
import AppMain from '@/components/AppMain';
import AppFooter from '@/components/AppFooter';

export default {
  components: {
    AppHeader,
    AppMain,
    AppFooter,
  },
};
</script>

<style scoped>

</style>
