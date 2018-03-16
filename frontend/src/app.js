/* eslint-disable import/no-extraneous-dependencies */
import Vue from 'vue';
import BootstrapVue from 'bootstrap-vue';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';
import Layout from '@/components/Layout';

Vue.use(BootstrapVue);
// eslint-disable-next-line
console.log(Layout);

const app = new Vue({
  el: '#app',
  // https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Spread_syntax
  ...Layout,
});

export default { app };
