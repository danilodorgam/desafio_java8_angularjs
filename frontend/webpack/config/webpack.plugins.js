var webpack = require('webpack');
var HtmlWebpackPlugin = require('html-webpack-plugin');
var DotenvPlugin = require('webpack-dotenv-plugin');
var ExtractTextPlugin = require("extract-text-webpack-plugin");


/*
  PLUGINS
 */
var plugins = [];

plugins.push(new DotenvPlugin({
    path: './.env',
    sample:'./.env.development'
}));


plugins.push(new webpack.ProvidePlugin({
    $: "jquery",
    jQuery: "jquery",
    "window.jQuery": "jquery",
    _: "lodash"
}));

plugins.push(
    new webpack.optimize.CommonsChunkPlugin({
        names: ['main', 'vendor'],
        minChunks: Infinity,
        children: false,
        async: false,
        deepChildren: false
    })
);

plugins.push(
    new HtmlWebpackPlugin({
        template: 'src/index.template.html',
        inject: true
    })
);

plugins.push(
    new ExtractTextPlugin({filename: '[name].[hash].css'})
);


module.exports = plugins;