SUMMARY = "Linux kernel recipe append for Rockchip platforms (Rock 5B+)"
DESCRIPTION = "Yocto bbappend recipe for linux-rockchip 6.1, adding custom configurations for Rock 5B+ meter applications."
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

# Add linux firmware for Rock 5B+ hardware support
IMAGE_INSTALL:append = " \
    linux-firmware \
"

# Additional kernel modules for Rock 5B+ hardware
IMAGE_INSTALL:append = " \
    kernel-modules \
"

# Rockchip kernel already has good filesystem support
# No additional kernel features needed for Rock 5B+

# Add any custom kernel configurations for Rock 5B+ if needed
# Note: Rockchip kernel already has good hardware support
# Use .cfg files for kernel configuration if needed
