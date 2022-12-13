// for both webpack.config.js and karma.conf.js

const autoprefixer = require('autoprefixer')

const extraEntry = {
    'webcomponents-loader': '@webcomponents/webcomponentsjs/webcomponents-loader.js',
};

config.entry = config.entry != null ? Object.assign(config.entry, extraEntry) : extraEntry;

if (config.output != null) {
    const kotlinJsFilename = config.output.filename;
    config.output.filename = chunkData =>
        chunkData.chunk.name in extraEntry ? "[name].js" : kotlinJsFilename(chunkData);
}
else
    config.output = { filename: "[name].js" };

// see: https://github.com/material-components/material-components-web/blob/master/docs/getting-started.md

const mainEntryExtras = ['./kotlin/css/theme.css',];
if (config.entry.main != null)
    config.entry.main.push(...mainEntryExtras);
else
    config.entry.main = mainEntryExtras;

config.module.rules.push({
    test: /\.s?css$/,
    use: [
        {
            loader: 'file-loader',
            options: {
                name: 'app.css',
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
