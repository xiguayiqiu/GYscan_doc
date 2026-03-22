#!/bin/bash

# 遍历所有md文件
for file in $(find /home/yiqiu/Android/gyscan-doc/app/src/main/assets -name "*.md"); do
    # 检查文件是否包含"## 5. 实战示例"部分
    if grep -q "## 5\. 实战示例" "$file"; then
        # 使用sed将"## 5. 注意事项"改为"## 6. 注意事项"
        sed -i 's/## 5\. 注意事项/## 6. 注意事项/g' "$file"
        # 使用sed将"## 7. 注意事项"改为"## 6. 注意事项"
        sed -i 's/## 7\. 注意事项/## 6. 注意事项/g' "$file"
        echo "修复文件: $file"
    else
        # 如果文件不包含"## 5. 实战示例"部分，将"## 6. 注意事项"或"## 7. 注意事项"改为"## 5. 注意事项"
        if grep -q "## 6\. 注意事项\|## 7\. 注意事项" "$file"; then
            sed -i 's/## 6\. 注意事项/## 5. 注意事项/g' "$file"
            sed -i 's/## 7\. 注意事项/## 5. 注意事项/g' "$file"
            echo "修复文件: $file"
        fi
    fi
done

echo "完成！"