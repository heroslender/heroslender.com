// for both webpack.config.js and karma.conf.js
const path = require('path');
const autoprefixer = require('autoprefixer')

const mainEntryExtras = ['./kotlin/css/theme.css',];
if (config.entry.main != null)
    config.entry.main.push(...mainEntryExtras);
else
    config.entry.main = mainEntryExtras;

config.module.rules.push({
    test: /bootstrap-reboot\.min\.css$/,
    type: 'asset/resource',
    generator: {
        filename: 'css/bootstrap-reboot.min.css'
    },
});

config.module.rules.push({
    test: /bootstrap-grid\.scss$/,
    use: [
        {
            loader: 'file-loader',
            options: {
                name: 'css/bootstrap-grid.css',
            },
        },
        {
            loader: 'postcss-loader',
            options: {
                postcssOptions: {
                    plugins: [
                        "postcss-import",
                        "cssnano",
                        autoprefixer()
                    ]
                }
            }
        },
        {
            loader: 'sass-loader',
            options: {
                // Prefer Dart Sass
                implementation: require('sass'),

                // See https://github.com/webpack-contrib/sass-loader/issues/804
                webpackImporter: false,
                sassOptions: {
                    includePaths: ['./node_modules']
                },
            },
        },
    ],
});

config.module.rules.push({
    include: path.resolve(__dirname, 'kotlin/css/theme.css'),
    use: [
        {
            loader: 'file-loader',
            options: {
                name: 'css/app.css',
            },
        },
        {
            loader: 'postcss-loader',
            options: {
                postcssOptions: {
                    plugins: [
                        "postcss-import",
                        "cssnano",
                        autoprefixer()
                    ]
                }
            }
        },
        {
            loader: 'sass-loader',
            options: {
                // Prefer Dart Sass
                implementation: require('sass'),

                // See https://github.com/webpack-contrib/sass-loader/issues/804
                webpackImporter: false,
                sassOptions: {
                    includePaths: ['./node_modules']
                },
            },
        },
    ],
});
