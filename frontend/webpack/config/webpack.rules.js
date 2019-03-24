var ExtractTextPlugin = require("extract-text-webpack-plugin");
var path = require('path');

/*
  RULES
 */
var rules = [];

rules.push({
    test: /\.js?$/,
    exclude: /node_modules/,
    loader: 'babel-loader',
    query: {
        presets: ['env'],
        plugins: ['transform-object-rest-spread', 'transform-async-to-generator']
    }
});

rules.push({
    test: /\.s?css/,
    use: ExtractTextPlugin.extract({
        fallback: 'style-loader',
        use: [
            {
                loader: 'css-loader',
                options: {
                    sourceMap: true
                }
            }
        ]
    })
});

rules.push({
    test: /\.less$/,
    use: ExtractTextPlugin.extract({
        fallback: 'style-loader',
        use: [
            {
                loader: 'css-loader',
                options: {
                    sourceMap: true
                }
            },
            {
                loader: 'less-loader',
                options: {
                    sourceMap: true
                }
            }
        ]
    })
});


rules.push({
    test: /\.png$/,
    loaders: ['url-loader?limit=1000000&name=assets/images/[hash].[ext]']
});

rules.push({
    test: /\.(woff2|woff|ttf|eot|svg)?(\?v=[0-9]\.[0-9]\.[0-9])?$/,
    use: [{
        loader: 'url-loader',
        options: {
            name: 'assets/fonts/[name]_[hash].[ext]'
        }
    }]
});

rules.push({
    test: /\.json$/,
    loaders: ['json-loader']
});

if (/^win/.test(process.platform)) {
    rules.push({
        test: /(views|layout|templates|directives|components)\\([\s\S]+)\.html$/,
        use: [{
            loader: 'ngtemplate-loader',
            query: {
                relativeTo: (path.resolve(__dirname, '../../src/app/')),
                pathSep: '/',
            }
        },
            {
                loader: 'html-loader',
                options: {
                    minimize: true
                }
            }
        ]
    });
    rules.push({
        test: /(ng-table)\\([\s\S]+)\.html$/,
        use: [{
            loader: 'ngtemplate-loader',
            query: {
                relativeTo: (path.resolve(__dirname, '../../node_modules/ng-table/src/browser')),
                prefix: 'ng-table'
            }
        },
            {
                loader: 'html-loader',
                options: {
                    minimize: true
                }
            }
        ]
    });
} else {
    rules.push({
        test: /(views|layout|templates|directives|components)\/([\s\S]+)\.html$/,
        exclude: /node_modules/,
        use: [{
            loader: 'ngtemplate-loader',
            query: {
                relativeTo: (path.resolve(__dirname, '../../src/app/'))
            }
        },
            {
                loader: 'html-loader',
                options: {
                    minimize: true
                }
            }
        ]
    });
    rules.push({
        test: /(ng-table)\/([\s\S]+)\.html$/,
        use: [{
            loader: 'ngtemplate-loader',
            query: {
                relativeTo: (path.resolve(__dirname, '../../node_modules/ng-table/src/browser')),
                prefix: 'ng-table'
            }
        },
            {
                loader: 'html-loader',
                options: {
                    minimize: true
                }
            }
        ]
    });
}

rules.push({
    test: /index.template\.html$/,
    loaders: [{
        loader: 'html-loader'
    }]
});

module.exports = rules;