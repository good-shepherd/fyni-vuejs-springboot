import Vue from 'vue';
import Layout from '@/components/Layout';

// eslint-disable-next-line
console.log(Layout);

const app = new Vue({
  el: '#app',
  // https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Spread_syntax
  ...Layout,
});

export default { app };
