var webpack = require('webpack');
var path = require('path');
var BundleAnalyzerPlugin = require('webpack-bundle-analyzer').BundleAnalyzerPlugin;
var config = require('./config/webpack.config');
var buildPath = path.join(__dirname, '../src/');

config.plugins.push(new webpack.HotModuleReplacementPlugin());


config.devtool = "source-map";

config.devServer = {
    contentBase: buildPath,
    hot: true,
    https: false,
    watchOptions: {
        ignored: /node_modules/
    },
    compress: false,
    inline: true,
    port: 3000,
    disableHostCheck: true,
};

module.exports = config;