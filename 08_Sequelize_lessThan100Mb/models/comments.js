const Sequelize = require('sequelize');

class Comment extends Sequelize.Model {
    static initiate(sequelize) {
        Comment.init({
            comment: {
                type: Sequelize.STRING(100),
                allowNull: false,
            },
            create_at: {
                type: Sequelize.DATE,
                allowNull: false,
                defaultValue: Sequelize.NOW,
            }
        }, {
            sequelize,
            timestamps: false,
            modelName: 'Comment',
            tableName: 'comments',
            paranoid: false,
            charset: 'utf8mb4',
            collate: 'utf8mb4_general_ci',
        });    
    }

    static associate(db) {
        db.Comment.belongsTo(db.User, { foreignKey: 'Commenter',
            targetKey: 'id' });
    }
}

module.exports = Comment;

// users 테이블과 연결된 commenter 컬럼이 없다 ??
// 이 부분은 모델을 정의할 때 넣어도 되지만,
// 시퀄라이즈 자체에서 관계를 따로 정의할 수 있는데,
// associate 메소드로 인해 comment 테이블은 user 테이블의
//  id를 commenter(외래키)로 하여 자신의 속성으로 갖을 수 있음


